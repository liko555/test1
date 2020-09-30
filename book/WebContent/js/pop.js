
$(".addpop").click(function(){
    $(".mask").show();
    $(".popdiv").show();
    $(".close").click(function(){
        $(".close").parent().hide();
        $(".mask").hide();
        // $(this).parent().prev().hide();
    })
})

$(".selpop").click(function(){
    $(".mask").show();
    $(".selPopdiv").show();
    $("input").attr("readonly","readonly");
    // $("pop").attr("readonly","readonly");
    $(".selPopdiv").css("padding","0 0 30px 0");
    // $(".modifysub").remove();
    // $(".btn").remove();
    $(".close").click(function(){
        $(".close").parent().hide();
        $(".mask").hide();
        // $(this).parent().prev().hide();
    })
})
$(".btn").click(function(){
    $("input").attr("readonly",false)
    // $("input").removeAttr("readonly");
})
$(".bookbtn").click(function(){
    $(".mask").show();
    $(".popdiv").show();
    $(".close").click(function(){
        $(".close").parent().hide();
        $(".mask").hide();
        // $(this).parent().prev().hide();
    })
})

const userPwd=document.getElementById('userPwd');
$("#userPwd").change(function(){
    var numberNo=this.value;
    var reg = /^[0-9]+$/; 
    if(reg.test(numberNo)==false){ 
        alert('只能输入数字！'); 
        return false; 
    }
})
const toggle1=document.getElementById('toggle1');
function showHide(){
    console.log(userPwd.type);
    if(userPwd.type=='password'){
        userPwd.setAttribute('type','text');
        toggle1.classList.add('hide');
    }else{
        userPwd.setAttribute('type','password');
        toggle1.classList.remove('hide');
    }
}
