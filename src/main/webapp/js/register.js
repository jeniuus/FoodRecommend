//==============로그인 유효성검사==============
		var regId = /^[a-zA-Z0-9-_]{5,15}$/;//id- 5~20자 (a~z, A~Z, 0~9, -, _만 입력가능)
		var regPw = /(?=.*\d{1,50})(?=.*[~`!@#$%\^&*()-+=]{1,50})(?=.*[a-zA-Z]{1,50}).{8,50}$/;//숫자, 특수문자, 영문 1개이상 사용하여 8자리 이상
		var regName = /^[가-힣]{2,15}$/; 
		var regEmail = /^([\w\.\_\-])*[a-zA-Z0-9]+([\w\.\_\-])*([a-zA-Z0-9])+([\w\.\_\-])+@([a-zA-Z0-9]+\.)+[a-zA-Z0-9]{2,8}$/;
			///^[0-9a-zA-Z-_.]{5,15}$/; // 이메일 0~9, a~z, A~Z, -, _, .내에서만 입력가능
		var regPhone = /^01([0|1|6|7|8|9])([0-9]{3,4})([0-9]{4})$/;//전화번호 ->첫숫자는 01+(0,1,6,7,8,9)/-는 무시한다/숫자만 입력가능
		
		var input = document.querySelectorAll('.check');
		console.log(input);
		
		function idCh() {//id유효성
			var err = document.querySelector('#idError');
			if (regId.test(input[0].value)) {
				err.innerText = "";
			} else {
				err.innerText = "5~15자 (a~z, A~Z, 0~9, -, _만 입력가능) ";
			}

		};
		
		function pw1Ch() {//패스워드 유효성
			var err = document.querySelector('#pw1Error');
			if (regPw.test(input[1].value)) {
				err.innerText = "";
			} else {
				err.innerText = "8자이상 (숫자, 특수문자, 영문 1개이상)";
			}
		};
				
		function pw2Ch() {//패스워드 확인 유효성
			var err = document.querySelector('#pw2Error');
			if (input[1].value == input[2].value) {
				err.innerText = "";
			} else {
				err.innerText = "비밀번호가 일치하지 않습니다.";
			}
		};

		function nameCh() {//이름유효성
			var err = document.querySelector('#nameError');
			
				if (regName.test(input[3].value)) {
					err.innerText = "";
				} else {
					err.innerText = "한글 2단어 이상 입력해 주세요.";
				}
			
		};
		
		function emailCh() {//이메일 유효성
			var err = document.querySelector('#emailError');
			
				if (regEmail.test(input[4].value)) {
					console.log('email 잘나옴')
					err.innerText = "";
				} else {
					console.log('email오류')
					err.innerText = "이메일 형식에 맞지 않습니다";
					input[4].focus();
				}
			
		};
		
		function phoneCh() {//핸드폰 유효성
			var err = document.querySelector('#phoneNumError');
			
				if (regPhone.test(input[5].value)) {			
					err.innerText = "";
				} else {			
					err.innerText = "전화번호 형식이 맞지 않습니다. -를 제외하고 입력해 주세요";
					input[5].focus();
				}
			
		};
		
		//keyup이벤트를 사용하여 매번 자판을 입력한후, 유효성 검사 진행
		input[0].addEventListener('keyup', idCh);
		input[1].addEventListener('keyup', pw1Ch);
		input[2].addEventListener('keyup', pw2Ch);
		input[3].addEventListener('keyup', nameCh);
		input[4].addEventListener('keyup', emailCh);
		input[5].addEventListener('keyup', phoneCh);
		
		window.onload = function() {
		document.join.onsubmit=function(){// 회원가입을 누른다면
			var errorStr = [ " 아이디를", " 비밀번호를", " 비밀번호 확인을", "성함을", "이메일을", "번호를","회원유형을" ];
		
			var error=document.querySelectorAll('.error_next_box');
			var checkbox = document.querySelector('#primary-checkbox');
			var phoneCheck = document.querySelector('#phoneDoubleChk');
			var idCheck = document.querySelector('#idcheckval');
		
			console.log(input);
         for (var i = 0; i < input.length-1; i++) { // -1 == submit제외 
            if (!input[i].value) { //입력하지 않은값 유효성처리
			
              error[i].innerHTML = errorStr[i]+ " 입력해 주세요.";
               input[i].focus(); // 포커스 이동
               return false; // 종료 (포커스 이동유지를 위해 false 종료)
            }
           

            error[i].innerHTML = "";
         }
         	
         	
         	//유효성 처리
			if (!regId.test(input[0].value)){//	아이디		
				var err = document.querySelector('#idError');
				err.innerText = "5~15자 (a~z, A~Z, 0~9, -, _만 입력가능) ";
				input[0].focus();
				return false;
			}
	
			
			if (!regPw.test(input[1].value)) {//패스워드
				var err = document.querySelector('#pw1Error');
				err.innerText = "8자이상 (숫자, 특수문자, 영문 1개이상)";
				input[1].focus();
				return false;
				}
	
			if (input[1].value !== input[2].value) {//패스워드 일치여부
			var err = document.querySelector('#pw2Error');
				err.innerText = "비밀번호가 일치하지 않습니다.";
				input[2].focus();
				return false;
			}

		
			
			
			if (!regName.test(input[3].value)) {//이름
				var err = document.querySelector('#nameError');
				err.innerText = "한글 2단어 이상 입력해 주세요.";
				input[3].focus();
				return false;
			}
			
	
			
			if (!regEmail.test(input[4].value)) {//이메일
				var err = document.querySelector('#emailError');	
				err.innerText = "5글자이상 숫자, 영문자, -, _, .내에서만 입력가능";
				input[4].focus();
				return false;
			}
			
			if (!regPhone.test(input[5].value)) {//핸드폰
				var err = document.querySelector('#phoneNumError');
				err.innerText = "전화번호 형식에 맞지 않습니다.";
				input[5].focus();
				return false;
			}
			
			
			if(!checkbox.checked){//개인정보처리 동의 여부
				alert("개인정보처리에 동의 하신분만 회원가입이 가능합니다");
				return false;
			}
			
			if(idCheck.value == false){//중복아이디 여부
				console.log(typeof idCheck.value);
				console.log(phoneCheck.value);
				alert("중복id입니다!");
				
				return false;
				
			}else{
				console.log(typeof idCheck.value)
				console.log(phoneCheck.value)
			}
			
			if(phoneCheck.value == false){//인증번호 여부
				alert("인증번호가 일치하지 않습니다!");
				return false;
			}else{
				console.log(typeof phoneCheck.value)
				console.log(phoneCheck.value)
			}
			
			
			
         
				alert("회원가입이 완료되었습니다. this+조의 멤버가 되신 것을 환영합니다!! :D");
			}
		}
		
