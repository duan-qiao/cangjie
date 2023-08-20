<script setup>
  import { reactive, onMounted, watch, ref } from 'vue'
  import { NButton, NPagination } from 'naive-ui'
  import TokenUnit from '../components/Tokenization.vue'
  import { getTokenization, saveTokenizer } from '../api/fenci'

  const state = reactive({
    list: [],
    loading: false,
    saving: false,
    pageNum: 1,
    pageSize: 10,
    pages: 0,
  })

  async function getTokenList() {
    state.loading = true
    state.list = []

    const params = {
      pageNum: state.pageNum,
      pageSize: state.pageSize
    }

    const res = await getTokenization(params)
    state.loading = false
    const { list, pages } = res
    state.list = list
    state.pages = pages
  }

  function removeToken(sentenceIndex, tokenIndex) {
    const item = state.list[sentenceIndex]
    item?.tokens?.splice(tokenIndex, 1)
  }
  function clearToken(sentenceIndex) {
    const item = state.list[sentenceIndex]
    item.tokens = []
  }
  function addToken(sentenceIndex, token) {
    const item = state.list[sentenceIndex]
    item?.tokens?.push(token)
  }

  async function handleBatchSave() {
    state.saving = true
    const res = await saveTokenizer(state.list)
    state.saving = false
    return res
  }

  function handlePageNumChange(page) {
    state.pageNum = page
    getTokenList()
  }

  function handlePageSizeChange(pageSize) {
    state.pageNum = 1
    state.pageSize = pageSize
    getTokenList()
  }

  onMounted(getTokenList)
</script>

<template>
  <header class="header">
    <n-button
      strong
      secondary
      type="info"
      class="save-btn"
      :disabled="state.saving"
      @click="handleBatchSave"
    >
      批量保存
    </n-button>
  </header>
  <main class="fenci-wrapper" v-if="state.list && state.list.length">
    <TokenUnit
      v-for="(unit,index) in state.list"
      :key="index"
      :unit="unit"
      :sentence-index="index"
      @add="addToken"
      @remove="removeToken"
      @clear="clearToken"
    />
    <div class="fc-pagination">
      <n-pagination
        :page="state.pageNum"
        :page-size="state.pageSize"
        :page-count="state.pages"
        show-size-picker
        :page-sizes="[10, 30, 50]"
        @update:page="handlePageNumChange"
        @update:page-size="handlePageSizeChange"
      />
    </div>
  </main>
  <div v-else></div>

</template>

<style scoped>
.header {
  width: 100%;
  height: 50px;
  position: sticky;
  display: flex;
  top: 0;
  align-items: center;
  border-bottom: 1px solid rgba(60, 60, 60, .12);
  background-color: #fff;
  z-index: 100;
}

.save-btn {
  position: absolute;
  right: 50px;
}

.fenci-wrapper {
  max-width: 960px;
  margin: 0 auto;
  padding: 10px 20px;
}
.fc-pagination {
  display: flex;
  width: 100%;
  flex-direction: row-reverse;
}
</style>
