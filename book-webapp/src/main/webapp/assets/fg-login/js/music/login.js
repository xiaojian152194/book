$('#loginButton').on('click',function(){
     var data = "{username:'"+$('#username').val()+"',password:'"+$('#password').val()+"'}";
     $.ajax({
       type:"POST",
       url:"api/book/login",
       data:data,
       contentType : 'application/json',
       dataType:"json",
       success:function(data){
         if(data.successResponse == true){
           window.location.href="index.html";
         }else{
          alert(data.message);
         }
       }
     });
   })