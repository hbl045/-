const storage = {
    set(key, value) {
        //JSON.stringify转换为JSON字符串，实现了前后端数据共同的效果
        localStorage.setItem(key,JSON.stringify(value));
    },
    get(key) {
        return localStorage.getItem(key)?localStorage.getItem(key).replace('"','').replace('"',''):"";
    },
    getObj(key) {
        // 这里用了三目运算符   JSON.parse转换为对象
        return localStorage.getItem(key)?JSON.parse(localStorage.getItem(key)):null;
    },
    remove(key) {
        localStorage.removeItem(key);
    }
}
export default storage;