let email = document.getElementById('email');
let password = document.getElementById('password');
let signin = document.getElementById('signin');



signin.addEventListener('click',async (e) => {
  e.preventDefault();
    // for integration to the backend database 

  const response = await fetch(`http://localhost:8080/customerlogin?email=${email.value}&password=${password.value}`);
  let x = await response.json();
  console.log(x.data.address);
  console.log(response.status);
  console.log("hello");
  let obj = JSON.stringify(x);
  if(response.status === 302){
    console.log(obj);
    window.localStorage.setItem('customer_id', x.data.id);
    window.localStorage.setItem('customer_name', x.data.name);
    window.localStorage.setItem('customer_email', x.data.email);
    window.localStorage.setItem('customer_phone', x.data.phone);
    window.localStorage.setItem('customer_password', x.data.password);
    window.localStorage.setItem('customer_familyCount', x.data.familyCount);
    window.localStorage.setItem('customer_addressid', x.data.address.id);
    window.localStorage.setItem('customer_doorNo', x.data.address.doorNo);
    window.localStorage.setItem('customer_street', x.data.address.street);
    window.localStorage.setItem('customer_district', x.data.address.district);
    window.localStorage.setItem('customer_landmark', x.data.address.landmark);
    window.localStorage.setItem('customer_state', x.data.address.state);
    window.localStorage.setItem('customer_pincode', x.data.address.pincode);
    window.alert("Login is completed Successfull...")
  }
// {"status":302,"data":{"id":1,"name":"Manoj Kodidala","email":"manoj17@gmail.com","phone":9160528864,"pwd":"123","familyCount":4,"address":{"id":1,"doorNo":"345/1","street":"Jp-Street","district":"bedhar","landmark":"railway","state":"KN","pincode":500082},"works":[{"id":1,"type":"Driver","startDate":"2023-08-05","endDate":"2023-08-29","address":{"id":11,"doorNo":"345/1","street":"Jp-Street","district":"bedhar","landmark":"railway","state":"KN","pincode":0},"vendors":[{"id":1,"name":"jack","email":"jack@gmail.com","pwd":"123","phone":958478574,"role":"driver","costPerDay":2000,"address":{"id":5,"doorNo":"852","street":"school","district":"hyd","landmark":"Tank","state":"ts","pincode":500082},"costs":[{"id":1,"mode":"Paytm","totalAmount":46500,"days":31}]}],"cost":{"id":1,"mode":"Paytm","totalAmount":46500,"days":31}},{"id":4,"type":"developer","startDate":null,"endDate":null,"address":{"id":14,"doorNo":"258","street":"hostel","district":"nlg","landmark":"church","state":"ts","pincode":0},"vendors":[],"cost":null}]},"message":"The Customer Login Successfull..."}

  // function o() {
    //open(URL="./customerpage.html");
  // }
  // o(); 
  
});