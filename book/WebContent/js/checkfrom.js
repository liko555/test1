$("#phoneno").change(function(){
    var phoneno = this.value;
    var phoPtrn=/^1[3456789][0-9]{9}$/;
    if(phoPtrn.test(phoneno)==false){
        alert("手机号不符合要求，请重新输入");
        this.focus();
    }
})
$("#number").change(function(){
    var numberNo=this.value;
    var reg = /^[0-9]+$/; 
    if(reg.test(numberNo)==false){ 
        alert('只能输入数字！'); 
        return false; 
    }
})