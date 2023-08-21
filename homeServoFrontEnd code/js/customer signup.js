let cname = document.getElementById('cname');
let email = document.getElementById('email');
let pwd = document.getElementById('pwd');
let phone = document.getElementById('phone');
let famcount = document.getElementById('famcount');
let dno = document.getElementById('dno');
let street = document.getElementById('street');
let landmark = document.getElementById('landmark');
let district = document.getElementById('district');
let state = document.getElementById('state');
let pincode = document.getElementById('pincode');
let pvalid = document.getElementById('pvalid');

// preventDefault() The page reload will be stopped

let input = document.getElementsByTagName('input');

let signup = document.getElementById('signup');


let regx = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$/;
// let test = regx.test(email.value);
// let bo = test.toString();
// console.log(bo);

let upper = /[A-Z]/ ;
let lower = /[a-z]/;
let num = /[0-9]/;
let spc = /[(?=.*-\/:-@\[-\`{-~]/;


signup.addEventListener('click', async (e) =>{
  e.preventDefault();

  // for form validation code
  let p = document.getElementsByTagName('p');
  console.log(p);
  if(cname.value ===''){
    p[0].innerHTML = 'This field should not empty';
    // p[0].innerHTML == 'This field should not empty';
    p[0].style.color = 'red';
    cname.style.borderColor = 'red';
  }
  else if(email.value === ''){
    p[1].innerHTML = 'This field should not empty';
    p[1].style.color = 'red';
    email.style.borderColor = 'red';
  }
  else if(phone.value === ''){
    p[2].innerHTML = 'This field should not empty';
    p[2].style.color = 'red';
    phone.style.borderColor = 'red';
  }
  else if(pwd.value === ''){
    p[3].innerHTML = 'This field should not empty';
    p[3].style.color = 'red';
    pwd.style.borderColor = 'red';
  }
  // else if(pwd.value !== ''){
  //   p[3].innerHTML = '';
  //   p[3].style.color = 'green';
  //   // pwd.style.borderColor = 'green';
  // }

  // else if(upper.test(pwd.value) === false){
  //   pvalid.innerHTML='this field should contain upper case characters';
  //   pvalid.style.color = 'red';
  //   pwd.style.borderColor = 'red';
  // }
  // else if(lower.test(pwd.value) === false){
  //   pvalid.innerHTML='this field should contain lower case characters';
  //   pvalid.style.color = 'red';
  //   pwd.style.borderColor = 'red';
  // }
    
  // else if(num.test(pwd.value) === false){
  //   pvalid.innerHTML='this field should contain numbers';
  //   pvalid.style.color = 'red';
  //   pwd.style.borderColor = 'red';
  // }
  // else if(regx.test(pwd.value) === false){
  //   pvalid.innerHTML='this field should contain special characters';
  //   pvalid.style.color = 'red';
  //   pwd.style.borderColor = 'red';
  // }

  else if(regx.test(pwd.value) === false){
    // console.log("Nameste");
    pvalid.innerHTML = `<ol>
    <li>This field must contain atlest one uppercase letter</li>
    <li>This field must contain atlest one lowercase letter</li>
    <li>This field must contain atlest one number</li>
    <li>This field must contain atlest one special character</li>
    </ol>`;
    pvalid.style.color = 'red';
    pwd.style.borderColor = 'red';
  }
  // else if(regx.test(pwd.value) === true){
  //   // console.log("Nameste");
  //   pvalid.innerHTML = '';
  //   pvalid.style.color = 'green';
  //   pwd.style.borderColor = 'green';
  // }

  else if(famcount.value === ''){
    p[4].innerHTML = 'This field should not empty';
    p[4].style.color = 'red';
    famcount.style.borderColor = 'red';
  }
  else if(dno.value === ''){
    p[5].innerHTML = 'This field should not empty';
    p[5].style.color = 'red';
    dno.style.borderColor = 'red';
  }
  else if(street.value === ''){
    p[6].innerHTML = 'This field should not empty';
    p[6].style.color = 'red';
    street.style.borderColor = 'red';
  }
  else if(landmark.value === ''){
    p[7].innerHTML = 'This field should not empty';
    p[7].style.color = 'red';
    landmark.style.borderColor = 'red';
  }
  else if(district.value === ''){
    p[8].innerHTML = 'This field should not empty';
    p[8].style.color = 'red';
    district.style.borderColor = 'red';
  }
  else if(state.value === ''){
    p[9].innerHTML = 'This field should not empty';
    p[9].style.color = 'red';
    state.style.borderColor = 'red';
  }
  else if(pincode.value === ''){
    p[10].innerHTML = 'This field should not empty';
    p[10].style.color = 'red';
    pincode.style.borderColor = 'red';
  }
  else{
    for(var i = 0; i< p.length; i++){
      p[i].innerHTML ='';
      p[i].style.color ='green';
      input[i].style.borderColor = 'green';
    }
    pvalid.innerHTML = '';
    pvalid.style.borderColor = 'green';
  }


  // cheking the backend table if the data is already present in the backend table


  // for integration to the backend database 

  if(cname.value != '' && email.value != '' &&  pwd.value != '' &&  phone.value != '' && famcount.value != '' && dno.value != '' && street.value != '' && landmark.value != '' && district.value != '' && state.value != '' && pincode.value != '' &&  regx.test(pwd.value) === true) {
  const customer = {
    'name' : cname.value,
    'email' : email.value,
    'phone' : phone.value,
    'password' : pwd.value,
    'familyCount' : famcount.value,
    'address' : {
      'd_no' : dno.value,
      'street' : street.value,
      'district' :district.value,
      'landmark' : landmark.value,
      'state' : state.value,
      'pinCode' : pincode.value
    }
  }
  try{
    const response = await fetch("http://localhost:8080/customer",
    {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(customer),
    });
    if(response.ok){
      const data = await response.json();
      console.log(data);
      window.alert("Congratulations you have successfully created a new customer Account 🥳🥳🥳");
    }
    
    if (response.status >= 400) {
      window.alert("Youre Already Registered Here Please Try To Login 😕😕😕");
      for(var i = 0; i< input.length; i++){
        input[i].style.borderColor = 'red';
      }
      // throw new Error("Youre Already Registered Here Please Try To Login 😕😕😕");
      
      
    }
    else{
      for(var i = 0; i< p.length; i++){
        input[i].style.borderColor = 'green';
      }
    }

    cname.value = '';
    email.value = '';
    phone.value = '';
    pwd.value = '';
    famcount.value = '';
    dno.value = '';
    street.value = '';
    landmark.value = '';
    district.value = '';
    state.value = '';
    pincode.value = '';
    for(var i = 0; i< p.length; i++){
      input[i].style.borderColor = 'none';
    }

  }
  catch(error){
    console.error("error", error);
    window.alert("error", error);
  }
  }
  else {
    window.alert("Please enter valid details");
  }
},false);