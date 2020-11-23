<template>
<v-theme-provider root>
  <v-card
    flat
    
    class="less-height"
  >
    <v-row style="flex-wrap: nowrap">
      <v-col
        class="col-pad flex-grow-1 flex-shrink-0"
        cols="8"
        style="min-width: 200px; "
      >

        <p  :class="modelo.qty > 0 ? 'pad-text title-text bold-text' : 'pad-text title-text' ">{{ modelo.title }}</p>
      </v-col>
      <v-col class="col-pad flex-grow-0 flex-shrink-1">
        <v-icon @click="incrementQty(modelo)" color="success" medium>mdi-plus</v-icon>
      </v-col>
      <v-col class="col-pad flex-grow-0 flex-shrink-1">
        <p class="pad-text title-text">{{ modelo.qty }}</p>
      </v-col>
      <v-col class="col-pad flex-grow-0 flex-shrink-1">
        <v-icon @click="decrementQty(modelo)" color="error" medium>mdi-minus</v-icon>
      </v-col>
    </v-row>
  </v-card>
</v-theme-provider>
</template>

<script>
export default {
  name: "CustomListItem",
  props: ["modelo"],
  methods: {
    incrementQty(child) {
      child.qty++;
    },
    decrementQty(child) {
      if (child.qty > 0) child.qty -= 1;
    },
  },
};
</script>

<style>
.qty-input {
  margin: 0 !important;
  padding-top: 0 !important;
  font-size: 13pt !important;
}
.pad-text {
  padding-top: 3px !important;
  padding-bottom: 0px !important;
}
.title-text {
  font-size: 13pt;
}
.col-pad {
  padding-bottom: 0 !important;
  padding-top: 0 !important;
}
.bold-text{
  font-weight: bold;
}

</style>