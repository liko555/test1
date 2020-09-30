(function(window,document){
    //封装选择器
    const getSelector=ele=>{
        return typeof ele==="string"?document.querySelector(ele):"";
    }
})(window,document)