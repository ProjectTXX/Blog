<template>
  <div class="pagination">
    <button :disabled="currentPage === 1" @click="changePage(currentPage - 1)">&#60;</button>
    <button v-for="page in totalPages" :key="page" :class="{ active: currentPage === page }" @click="changePage(page)">{{ page }}</button>
    <button :disabled="currentPage === totalPages" @click="changePage(currentPage + 1)">&#62;</button>
  </div>
</template>

<script>
export default {
  props: {
    total: {  //评论总数
      type: Number,
      required: true
    },
    current: {  //当前页码
      type: Number,
      required: true
    },
    perPage: {  //每页显示评论数
      type: Number,
      default: 5
    }
  },
  computed: {
    totalPages() {  //计算总页数
      return Math.ceil(this.total / this.perPage);
    },
    currentPage() {  // 当前页码
      return this.current;
    }
  },
  methods: {
    changePage(page) {  //传递新的页码
      if (page > 0 && page <= this.totalPages) {
        this.$emit('page-changed', page);
      }
    }
  }
};
</script>

<style scoped>
.pagination {
  display: flex;
  justify-content: center;
  align-items: center;
  margin-top: 20px;
  gap: 8px; /* 按钮之间的间隔 */
}

button {
  border: none;
  background-color: #f0f0f0;
  color: #333;
  padding: 8px 14px;
  cursor: pointer;
  border-radius: 6px;
  font-size: 14px;
  transition: background-color 0.3s ease, color 0.3s ease;
}

button:hover:not(.active):not(:disabled) {
  background-color: #e0e0e0;
}

button:disabled {
  cursor: not-allowed;
  color: #ccc;
}

button.active {
  background-color: #007bff;
  color: white;
}

button.active:hover {
  background-color: #0069d9;
}
</style>
