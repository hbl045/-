<template>
  <div>
    <img class="bg" src="@/assets/img/bg.jpg">
    <el-form :model="rulesForm" :rules="rules" ref="rulesForm" class="login-form">
      <h1 class="h1">BMW别摸我会员中心入口</h1>
      <!--账号 和 密码 -->
      <el-form-item label="账号" prop="username">
        <!-- v-model 双向绑定 -->
        <el-input type="text" v-model="rulesForm.username"></el-input>
      </el-form-item>
      <el-form-item label="密码" prop="password">
        <el-input type="password" v-model="rulesForm.password"></el-input>
      </el-form-item>
      <!-- 权限判断     通过menu表确定目标的 -->
      <el-form-item label="" prop="role">
        <el-radio v-for="item in menus" v-bind:key="item.roleName" v-model="rulesForm.role" :label="item.roleName">
          {{ item.roleName }}
        </el-radio>
      </el-form-item>
      <!-- 注册表-->
      <el-form-item label="">
        <a style="margin-right: 10px" href="javascript:void(0)" @click="register('yonghu')">注册用户</a>
        <a style="margin-right: 10px" href="javascript:void(0)" @click="register('qiyexinxi')">注册企业信息</a>
      </el-form-item>
      <!-- 点击按钮     -->
      <el-button @click="login()" class="btn-login" type="primary" round>登陆</el-button>

    </el-form>
  </div>
</template>

<script>
import menu from "@/utils/menu";

export default {
  data() {
    return {
      rulesForm: {
        username: "",
        password: "",
        role: ""
      },
      menus: [],
      tableName: "",
      rules: {
        username: [{required: true, message: "尊贵的BMW会员，请输入账号", trigger: "blur"}],
        password: [{required: true, message: "尊贵的BMW会员，请输入密码", trigger: "blur"}],
        role: [{required: true, message: "请选择角色", trigger: "blur"}]
      }
    };
  },
  mounted() {
    let menus = menu.list();
    this.menus = menus;
  },
  methods: {
    //注册
    register(tableName) {
      this.$storage.set("loginTable", tableName);
      this.$router.push({path: '/register'})
      // console.log("跳转登陆")
      // console.log(this.$storage.get("loginTable"))
    },
    //登陆
    login() {
      // //this是一个array数组
      //  console.log(this);
      // //跳转语句
      // this.$router.replace({path:"/index/"});
      // method拼错导致，显示的方法不是post,而是get ，所以要从源头找

      this.$refs["rulesForm"].validate(valid => {
        let menus = this.menus;
        for (let i = 0; i < menus.length; i++) {
          if (menus[i].roleName == this.rulesForm.role) {
            this.tableName = menus[i].tableName
          }
        }
        if (valid) {
          // console.log("1、准备提交给后台")
          this.$http({
            url: `${this.tableName}/login?username=${this.rulesForm.username}&password=${this.rulesForm.password}`,
            method: "post"
          }).then(({data}) => {
            // console.log("4、后台返回值")
            if (data && data.code === 0) {
              this.$storage.set("Token", data.token);
              this.$storage.set("role", this.rulesForm.role);
              this.$storage.set("sessionTable", this.tableName);
              this.$storage.set("adminName", this.rulesForm.username);
              this.$router.replace({path: "/index/"});
            } else {
              this.$message.error(data.msg);
            }
          });
        }
      });
    }
  }
}
</script>
<style lang="scss" scoped>
</style>