$('#registerButton').on('click',function(){
     var username = $('#username').val();
     var password = $('#password').val();
     if(username != "" || password != ""){
       var data = "{username:"+username+",password:"+password+"}";
       $.ajax({
         type:"POST",
         url:"api/book/register",
         data:data,
         contentType : 'application/json',
         dataType:"json",
         success:function(data){
           if(data.successResponse == true){
             alert('注册成功');
             window.location.href="login.html";
           }else{
            alert(data.message);
           }
         }
       });
     }else{
       alert('请填入必填项');
     }
   })