<template>
  <div class="tag-container">
    <button
      class="tag"
      v-for="tag in tags"
      :key="tag.id"
      :style="{ backgroundColor: tag.color }"
      @click="$router.push(tag.path)"
    >
      {{ tag.text }}
    </button>
  </div>
</template>

<script>
export default {
  data() {
    return {
      tags: [
        { id: 1, text: "1", color: "#E5D430", path: "" },
        { id: 2, text: "2", color: "#23CA9F", path: "" },
        { id: 3, text: "3", color: "#7E5DB6", path: "" },
        { id: 4, text: "4", color: "#AFDB59", path: "" },
        { id: 5, text: "5", color: "#4BC67D", path: "" },
        { id: 6, text: "6", color: "#90B4FE", path: "" },
        { id: 7, text: "7", color: "#794812", path: "" },
        { id: 8, text: "8", color: "#93A06D", path: "" },
        { id: 9, text: "9", color: "#E538A7", path: "" },
        { id: 10, text: "10", color: "#72EAC1", path: "" },
        { id: 11, text: "11", color: "#259317", path: "" },
        { id: 12, text: "12", color: "#620FCB", path: "" },
        { id: 13, text: "13", color: "#92B754", path: "" },
        { id: 14, text: "14", color: "#2A8C53", path: "" },
        { id: 15, text: "15", color: "#BF9576", path: "" },
        { id: 16, text: "16", color: "#F20A3D", path: "" },
        { id: 17, text: "17", color: "#E764AF", path: "" },
        { id: 18, text: "18", color: "#71890D", path: "" },
        { id: 19, text: "19", color: "#8D62C4", path: "" },
        { id: 20, text: "20", color: "#681453", path: "" },
        { id: 21, text: "21", color: "#16BCAE", path: "" },
        { id: 22, text: "22", color: "#21609B", path: "" },
        { id: 23, text: "23", color: "#FE023D", path: "" },
        { id: 24, text: "24", color: "#279E4A", path: "" },
        { id: 25, text: "25", color: "#F04769", path: "" },
        { id: 26, text: "26", color: "#93A680", path: "" },
        { id: 27, text: "27", color: "#BD8617", path: "" },
        { id: 28, text: "28", color: "#1D67CE", path: "" },
        { id: 29, text: "29", color: "#FA8967", path: "" },
        { id: 30, text: "30", color: "#523F08", path: "" },
      ],
    };
  },
};
</script>

<style>
.tag-container {
  display: flex;
  flex-wrap: wrap;
  justify-content: flex-start;
}

.tag {
  padding: 10px 20px;
  margin: 5px;
  border-radius: 5px;
  background-color: #f0f0f0;
  cursor: pointer;
}
</style>
