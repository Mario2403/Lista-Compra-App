<template>
  <v-app>
    <v-main>
      <ShoppingList />
    </v-main>
  </v-app>
</template>

<script>
    import ShoppingList from "./components/ShoppingList";


    export default {
  name: "App",

  components: {
    ShoppingList
  },

  data: () => ({
    //
  })
};
</script>
