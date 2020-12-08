<template>
  <div>
    <v-row>
      <v-col>
        <v-card class="pa-2" flat>
          <v-row>
            <v-col>
              <v-dialog v-model="showModal" max-width="290">
                <template v-slot:activator="{ on, attrs }">
                  <v-btn
                    color="primary"
                    dark
                    v-bind="attrs"
                    v-on="on"
                    @click="clearModal()"
                  >
                    Añadir un elemento
                  </v-btn>
                </template>
                <v-card class="pa-2">
                  <v-card-title class="headline">
                    Añadir un elemento
                  </v-card-title>
                  <v-row>
                    <v-col>
                      <v-text-field label="Nombre" v-model="textField">
                      </v-text-field>
                    </v-col>
                  </v-row>
                  <v-row>
                    <v-col>
                      <v-combobox
                        v-model="typeSelected"
                        item-text="title"
                        name="item"
                        :items="grupos"
                        label="Tipo"
                      >
                        <template slot="item" slot-scope="data">
                          <v-icon>{{ data.item.icon }}</v-icon>
                          {{ data.item.title }}
                        </template>
                      </v-combobox>
                    </v-col>
                  </v-row>
                  <v-row class="justify-center pa-3">
                    <v-btn @click="addNewItem()" color="success">Añadir</v-btn>
                    <v-spacer />
                    <v-btn @click="showModal = false" color="error"
                      >Borrar</v-btn
                    >
                  </v-row>
                </v-card>
              </v-dialog>
            </v-col>
          </v-row>
        </v-card>
      </v-col>
      <v-col cols="1"> </v-col>
      <v-col>
        <v-switch
          color="primary"
          @click="$vuetify.theme.dark = !$vuetify.theme.dark"
        >
        </v-switch>
      </v-col>
    </v-row>
    <v-row class="pa-1">
      <v-col>
        <!-- LISTA DE ELEMENTOS -->
        <v-list>
          <v-list-group
            v-for="item in grupos"
            :key="item.title"
            :prepend-icon="item.icon"
            no-action
          >
            <template v-slot:activator>
              <v-list-item-content>
                <v-list-item-title
                  v-text="item.title"
                  class="group-title"
                ></v-list-item-title>
              </v-list-item-content>
            </template>

            <v-list-item
              v-for="child in item.items"
              :key="child.title"
              class="no-pad"
              height="20"
            >
              <CustomListItem
                v-bind:modelo="child"
                :saveElements="saveElements"
              />
            </v-list-item>
          </v-list-group>
        </v-list>
        <!-- FIN LSITA DE ELEMENTOS -->
      </v-col>
    </v-row>
    <v-row>
      <v-col> </v-col>
      <v-col>
        <v-btn @click="generateList()" color="primary">Generar lista!</v-btn>
      </v-col>
      <v-col>
        <v-dialog v-model="modalInfo" max-width="290">
          <template v-slot:activator="{ on, attrs }">
            <v-btn icon v-bind="attrs" v-on="on">
              <v-icon> mdi-information-variant</v-icon>
            </v-btn>
          </template>
          <v-card class="pa-2">
            <v-card-title class="headline justify-center"
              >Información</v-card-title
            >
            <v-card-text style="text-align: center"
              >Lista de la compra APP <br />V.1.0</v-card-text
            >

            <v-card-subtitle style="text-align: center"
              >®Mario Jurado Soba - 2020</v-card-subtitle
            >
          </v-card>
        </v-dialog>
      </v-col>
    </v-row>
  </div>
</template>

<script>
import CustomListItem from "./CustomListItem.vue";

export default {
  name: "ShoppingList",
  components: {
    CustomListItem,
  },
  data() {
    return {
      grupos: [],
      /* {
          title: "CARNICERÍA",
          icon: "mdi-food-drumstick",
          items: [
            { title: "Carne picada", qty: 0 },
            { title: "Filtes de pollo", qty: 0 },
            { title: "Filetes cinta de lomo", qty: 0 },
          ],
        },
        {
          title: "PESCADERÍA",
          icon: "mdi-fish",
          items: [
            { title: "Salmón", qty: 0 },
            { title: "Bacalao pescanova", qty: 0 },
            { title: "Gallos", qty: 0 },
          ],
        },
        {
          title: "FRUTERÍA",
          icon: "mdi-food-apple",
          items: [
            { title: "Platános", qty: 0 },
            { title: "Peras", qty: 0 },
            { title: "Sandía", qty: 0 },
            { title: "Manzanas", qty: 0 },
            { title: "Ciruelas", qty: 0 },
            { title: "Melocotones", qty: 0 },
            { title: "Melón", qty: 0 },
          ],
        },
        {
          title: "PANADERÍA",
          icon: "mdi-baguette",
          items: [
            { title: "Pan Sebas", qty: 0 },
            { title: "Pan integral", qty: 0 },
            { title: "Pan de molde", qty: 0 },
          ],
        },
        {
          title: "VERDULERÍA",
          icon: "mdi-seed",
          items: [{ title: "Pimientos", qty: 0 }],
        },
        {
          title: "DROGUERÍA",
          icon: "mdi-lotion",
          items: [
            { title: "Lejía", qty: 0 },
            { title: "Amoníaco", qty: 0 },
            { title: "Friegasuelos verde", qty: 0 },
            { title: "Don Limpio baño", qty: 0 },
          ],
        },
        {
          title: "VARIOS",
          icon: "mdi-dice-multiple",
          items: [
            { title: "Cruesli", qty: 0 },
            { title: "Patatas fritas", qty: 0 },
          ], 
        },
      ],*/
      textField: "",
      elements: [],
      showModal: false,
      typeSelected: { title: "", icon: "" },
      modalInfo: false,
    };
  },
  methods: {
    addElement() {
      if (this.textField != "") {
        this.elements.push(this.textField);
        this.textField = "";
      }
    },
    generateList() {
      var postBody = {};
      var lista = [];
      for (var i = 0; i < this.grupos.length; i++) {
        //for  (var grupo in this.grupos) {
        var categoria = {};
        categoria.articulos = [];
        for (var j = 0; j < this.grupos[i].items.length; j++) {
          console.log(this.grupos[i].items[j].qty);
          if (this.grupos[i].items[j].qty > 0) {
            categoria.name = this.grupos[i].title;

            categoria.articulos.push(this.grupos[i].items[j]);
          }
        }

        if (
          categoria.name != undefined &&
          categoria.name != null &&
          categoria.name != ""
        ) {
          lista.push(categoria);
        }
      }
      postBody.categorias = lista;
      console.log(JSON.stringify(postBody));

      //send to backend

      const reqOptions = {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(postBody),
      };
      console.log("https://lista-compra-casa.herokuapp.com/api/list");
      fetch(
        "https://lista-compra-casa.herokuapp.com/api/list",
        reqOptions
      ).then((response) => console.log(response));
    },
    addNewItem() {
      console.log(this.typeSelected);
      console.log(this.textField);
      this.typeSelected.items.push({ title: this.textField, qty: 1 });
      this.showModal = false;

      const reqOptions = {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: { grupoName: this.typeSelected.title, itemName: this.textField },
      };
      //fetch("https://lista-compra-casa.herokuapp.com/api/grupos", reqOptions).then((response) =>{
      fetch(
        "https://lista-compra-casa.herokuapp.com/api/addGrupo",
        reqOptions
      ).then((response) => console.log(response));
    },
    clearModal() {
      this.textField = "";
      this.typeSelected = { title: "", icon: "" };
    },
    saveElements() {
      console.log("Save elements!");
      var saveJSON = JSON.stringify(this.grupos);
      localStorage.setItem("grupos", saveJSON);
    },
  },
  created() {
    if (localStorage.getItem("grupos") != undefined) {
      console.log("if grupos");
      var parsedJSON = JSON.parse(localStorage.getItem("grupos"));
      this.grupos = parsedJSON;
    } else {
      const reqOptions = {
        method: "GET",
        headers: { "Content-Type": "application/json" },
      };
           fetch("https://lista-compra-casa.herokuapp.com/api/grupos", reqOptions)
     .then((response) => response.json())
     .then((data) => this.grupos = data.grupos.grupos)

      //var url = "https://lista-compra-casa.herokuapp.com/api/grupos";
    }
  },
};
</script>

<style>
.no-pad {
  padding-left: 20px !important;
  margin-bottom: 0 !important;
  min-height: 10px !important;
  line-height: 0.8 !important;
}
.group-title {
  font-size: 13pt !important;
  text-align: center;
}
</style>