<script setup>
  import { ref } from 'vue'
  import { NTag, NSpace } from 'naive-ui'

  const emits = defineEmits(['add', 'remove', 'clear'])
  const props = defineProps({
    unit: Object,
    sentenceIndex: Number
  })
  const { unit, sentenceIndex } = props
  const { sentence, tokens } = unit
  const words = ref([])
  function getSelectedWord() {
    const txt = window.getSelection
      ? window.getSelection().toString()
      : document.selection.createRange().text
    return txt;    
  }
  function handleAdd() {
    const word = getSelectedWord()
    if(word === '') return false
    emits('add', sentenceIndex, {
      word,
      category: null
    })
  }
  function handleRemove(index) {
    emits('remove', sentenceIndex, index)
  }
</script>

<template>
  <div class="fenci-unit">
    <div @mouseup="handleAdd">{{ sentence }}</div>
    <div class="words-box">
      <n-space>
        <n-tag
          v-for="(item, index) in tokens"
          :key="item + '_' + index"
          size="small"
          type="success"
          closable
          @close="handleRemove(index)"
        >
          {{item.word}}
        </n-tag>
      </n-space>
    </div>
  </div>
</template>

<style scoped>
.fenci-unit {
  margin: 10px 0px;
}
.words-box {
  width: 100%;
  height: 80px;
  padding: 5px 10px;
  overflow-y: auto;
  border-radius: 5px;
  border: 1px solid #ddd;
}
</style>
