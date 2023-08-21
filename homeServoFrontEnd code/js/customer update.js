let id = document.getElementById('id');
let name = document.getElementById('name');
let email = document.getElementById('email');
let password = document.getElementById('password');
let phone = document.getElementById('phone');
let familyCount = document.getElementById('familyCount');
let d_no = document.getElementById('d_no');
let street = document.getElementById('street');
let landmark = document.getElementById('landmark');
let district = document.getElementById('district');
let state = document.getElementById('state');
let pinCode = document.getElementById('pinCode');
let p = document.getElementById('idvalid');

console.log(p);

let signup = document.getElementById('signup');




signup.addEventListener('click', async (e)=>{
  e.preventDefault();

  console.log(cid.value);

  if(id.value === ''){
    // p.innerHtml = "this field is required";
    p.innerHTML = 'this field is required';
    p.style.color = "red";
  }
  else{
    p.innerHTML = "";
    p.style.color = "green";
  }
  if(id.value != ''){
    const customer = {
      'id': id.value,
      'name' : name.value,
      'email' : email.value,
      'phone' : phone.value,
      'password' : password.value,
      'familyCount' : familyCount.value
      // 'address' : {
      //   'doorNo' : d_no.value,
      //   'street' : street.value,
      //   'district' :district.value,
      //   'landmark' : landmark.value,
      //   'state' : state.value,
      //   'pincode' : pincode.value
      // }
    } 
  
    try{
      const response = await fetch('http://localhost:8080/customer',{
        method: 'PUT',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(customer),
      });
      if(response.status===302){
        console.log('Update successful');
        window.alert('Update completed successfully...🥳🥳🥳');  
      }
      if(response.status===404){
        console.log('update unsuccessfull');
        window.alert('Please enter The Valid Customer ID....😕😕😕');
      }
    }
    catch(error){
      window.alert("error")
    }
  }
  else{
    alert('please enter the customer id ...');
  }
  
});