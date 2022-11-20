//正则表达式的语句

/**
 * 邮箱
 * @param s
 * @returns {boolean}
 */
export function isEmail (s) {
    return /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((.[a-zA-Z0-9_-]{2,3}){1,2})$/.test(s)
}

/**
 * 手机号码
 * @param s
 * @returns {boolean}
 */
export function isMobile (s){
    return /^1[0-9]{10}$/.test(s)
}

/**
 * 电话号码
 * @param s
 * @returns {boolean}
 */
export function  isPhone (s) {
    return /^([0-9]{3,4}-)?[0-9]{7,8}$/.test(s)
}

/**
 * URL地址
 * @param {*} s
 * @returns {boolean}
 */
export function isURL (s){
    return /^http[s]?:\/\/.*/.test(s)
}

/**
 * 配置数字，可以是小数，不可以是负数，可以为空
 * @param s
 * @returns {boolean}
 */
export function isNumber(s){
    return  /(^-?[+-]?([0-9]*\.?[0-9]+|[0-9]+\.?[0-9]*)([eE][+-]?[0-9]+)?$)|(^$)/.test(s);
}

/**
 * 匹配整数： 可以为空
 * @param s
 * @returns {boolean}
 */
export function isIntNumber(s){
    return  /(^-?\d+$)|(^$)/.test(s);
}

/**
 * 身份证验证
 * @param idcard
 * @returns {boolean}
 */
export function checkIdCard(idcard) {
    const regIdCard = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
    if(!regIdCard.test(idcard)) {
        return false;
    }else{
        return true;
    }
}
