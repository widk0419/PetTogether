<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <section>
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-7 col-xs-10 login-form">
                    <div class="titlebox">
                    
                    </div>
                    <form action="login" method="post" >
                        <div class="form-group"><!--사용자클래스선언-->
<<<<<<< HEAD
                        	<span id="msg"></span>
=======
>>>>>>> c9f84d91242e411ff872c951b0b90da2da8f5e66
                            <label for="id">아이디</label>
                            <input type="text" class="form-control" name="id" id="id" placeholder="아이디">
                         </div>
                         <div class="form-group"><!--사용자클래스선언-->
                            <label for="id">비밀번호</label>
                            <input type="password" class="form-control" name="pw" id="pw" placeholder="비밀번호">
                         </div>
                         <div class="form-group">
                            <button type="submit" class="btn btn-info btn-block" id="loginBtn">로그인</button>
                            <button type="button" class="btn btn-primary btn-block" onclick="location.href='userJoin'">회원가입</button>
                         </div>
                    </form>                
                </div>
            </div>
        </div>
    </section>

    <script>
<<<<<<< HEAD
	    var msg = "${login}";
		if(msg != ""){
			alert(msg);
		}
=======
    	var msg="${msg}";
    	
    	if(msg != ""){
    		alert(msg);
    	}
>>>>>>> c9f84d91242e411ff872c951b0b90da2da8f5e66
    	
    	<%-- 
    	$("#loginBtn").click(function(){
    		
    		var id = $("#userId").val();
    		var pw = $("#userPw").val();
    		
    		if( id == '' || pw == '' ){
        		alert("아이디와 비밀번호를 입력하세요.")
        		return;
        	}else{
        		$.ajax({
        			type: "POST",
        			url: "userLogin",
        			data: JSON.stringify({"userId": id,"userPw":pw}),
        			contentType: "application/json; charset=utf-8",
        			success:function(data){
        				if(data == 1){
        					alert("로그인 성공입니다.");
        					location.href="userMypage";
        				}else{
        					alert("로그인 실패.아이디와 비밀번호를 확인하세요")
        					$("#userName").focus();
        					return;
        				}
        			},
        			error: function(status,error){
        				
        			}
        		})
        	}
    		
    	})
    		--%>
    	
    	
    </script>