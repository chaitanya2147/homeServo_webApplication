let customer=document.getElementById("customer")
console.log(customer);
customer.addEventListener("click",()=>{
  //  console.log("hello")
  let demo=document.getElementById("sub-nav1")
  console.log(demo);
 let display= demo.classList.toggle("true")
 if(display){
    demo.style.display="block"
 }
 else{
    demo.style.display="none"
 }
})
let vendor=document.getElementById("vendor")
console.log(vendor);

vendor.addEventListener("click",()=>{
  //  console.log("hello")
  let demo=document.getElementById("sub-nav2")
  console.log(demo);
 let display= demo.classList.toggle("true")
 if(display){
    demo.style.display="block"
 }
 else{
    demo.style.display="none"
 }
})
//code starts for service functionality
let service=document.getElementById("service")
console.log(service);
service.addEventListener("click",()=>{
let drop_down=document.querySelector("#drop-down")
console.log(drop_down);
let display =drop_down.classList.toggle("none")
if(display){
drop_down.style.display="block"
}
else{
   drop_down.style.display="none"
}
})
let bg_image=document.getElementById("bg-image")
console.log(bg_image);
bg_image.addEventListener("click",()=>{
let drop_down=document.querySelector("#drop-down")
console.log(drop_down);
let display =drop_down.classList.toggle("block")
if(display){
drop_down.style.display="none"
}
})