<template>
  <div class="background">
    <img class="background" src="@/assets/img/404.png" alt>
    <div class="text">出错了。。。页面失踪了</div>
    <el-button class="text" @click="back()" type="text" icon="el-icon-back">返回</el-button>
  </div>
</template>

<script>
export default {
  methods:{
    //返回上一页，没有上一页就返回首页
    back(){
      window.history.length > 1 ? this.$router.go(-1) : this.$router.push('/')
    }
  }
}
</script>

<style lang="scss" scoped>
.container {
  position: absolute;
  left: 0;
  top: 0;
  width: 100%;
  height: 100%;
  text-align: center;
  .background {
    width: 200px;
    height: 200px;
    margin-top: 10%;
  }
  .text{
    font-size: 24px;
    font-weight: bold;
    color: #1296db;
    margin-top: 10px;
  }
}
</style>