let navbar = document.querySelector('.header .navbar');

document.querySelector('#menu-btn').onclick = () =>{
  navbar.classList.toggle('active');
  loginForm.classList.remove('active');
}

document.addEventListener('DOMContentLoaded', function () {
        const loginForm = document.querySelectorAll('.login-form')[0];
        const signupForm = document.querySelectorAll('.login-form')[1];

        // Function to switch to signup form
        function switchToSignUp(event) {
            event.preventDefault(); // Prevent default link behavior
            loginForm.style.display = 'none';
            signupForm.style.display = 'block';
        }

        // Add event listener to "Login Now" link
        const loginLink = loginForm.querySelector('.btn:nth-child(3)'); // Selecting the third link in login form
        loginLink.addEventListener('click', switchToSignUp);
    });



window.onscroll = () =>{
  navbar.classList.remove('active');
  loginForm.classList.remove('active');
}

var swiper = new Swiper(".review-slider",{
  spaceBetween: 20,
  centeredSlides: true,
  grabCursor: true,
  autoplay:{
    delay: 7500,
    disableOnInteraction: false,
  },
  loop: true,
  breakpoints: {
    0: {
      slidesPerView: 1,
    },
    768: {
      slidesPerView: 2,
    },
    991: {
      slidesPerView: 3,
    },
  },
});

document.addEventListener("DOMContentLoaded", function() {
  let currentSlide = 0;
  const slides = document.querySelectorAll('.slider img');
  const totalSlides = slides.length;

  function showSlide(n) {
    slides.forEach(slide => slide.style.display = "none");
    slides[n].style.display = "block";
  }

  function nextSlide() {
    currentSlide = (currentSlide + 1) % totalSlides;
    showSlide(currentSlide);
  }

  // Automatically advance slides every 3 seconds
  setInterval(nextSlide, 3000);

  // Optionally, you can add navigation controls (buttons) for users to manually control the slides
});

//alert

function makePayment(){
  setTimeout(function(){

      alert("!!Congratulations! your course has been approved.!!");
  }, 4000);
}

//card detail

let cart_data = JSON.parse(localStorage.getItem("3SV"))
    
// let cart_data = null
        var total = 0
        var count = 0
        var total_price = 0 ;
    if(cart_data == null){
       var div =  document.getElementById("cart_items")
       div.setAttribute("class", "cart_item")
       
       var img = document.createElement("img")
       img.src = "https://s.udemycdn.com/browse_components/flyout/empty-shopping-cart-v2"


       var para = document.createElement("p")
       para.textContent = "Your cart is empty. Keep shopping to find a course"

       var button = document.createElement("button")
       button.textContent = "Keep shopping"


       button.setAttribute("class", "buttons")
       var link = document.createElement("a")
       link.href = "home_page.html"
       link.append(button)
       

       div.append(img,para,link)
       var p_item = document.getElementById("coursenum")
       p_item.textContent = `${total} Courses in the cart`
    }
    else {
    
        cart_data.forEach(function(product){
            let parent =  document.getElementById("cart_items")
         parent.setAttribute("class", "cart_items")


          // below is row div 
            let row_div = document.createElement("div")

            row_div.setAttribute("class", "cart-div")


            let div1 = document.createElement("div")
            div1.setAttribute("class", "div1-style")

            let image = document.createElement("img")


            image.src = product.image

            let div2 = document.createElement("div")
            div2.setAttribute("class", "div2-style")

            let c_name = document.createElement("h3")

            c_name = product.name
           // c_name.setAttribute("style", "font-weight:500") not working full row box is hidden when i apply this property

            let brea = document.createElement("br")  

            let author = document.createElement("p")
            
            author.textContent = `By ${product.author}`
            //author.setAttribute("style", "font-weight:300")

            
            let bre = document.createElement("br")  


            let div3 = document.createElement("div")
            div3.setAttribute("class", "div3-style")


            let remov = document.createElement("button")
            remov.textContent = "Remove"
           // remove.setAttribute("id","save-later1")
            

            let later = document.createElement("button")
            later.textContent = "Save for later"
           // later.setAttribute("id","save-later2")
            
          

           
            let div4 = document.createElement("div")

            div4.setAttribute("class", "div4-style")

              let p_price = document.createElement("p")


            p_price = product.price
            
            div1.append(image)

            div2.append(c_name , author)

            div3.append(remov,later)


            div4.append(p_price)



            row_div.append(div1, div2,div3,div4)
           
            count++
            total = total + count

          // row div append to parent div
            parent.append(row_div)





            let str_price = ""
            for(var i = 0; i < product.price.length; i++){

                if(product.price[i] == "$"){
                continue
             }  
             else {
                str_price = str_price + product.price[i]
             }

            }




            // var total_div = document.createElement("div")
            // total_div.setAttribute("class", "total-div")

          

            total_price = total_price + Number(str_price)
            console.log("total" + total_price)

               
                
           
            let final_price = document.getElementById("total_prie")
           // final_price.setAttribute("class", "total-div")
            final_price.textContent =   "$"+total_price
             //.append(pura_total)
           
            // total_show.append(total_div)

            
           
           


            var p_item = document.getElementById("coursenum")
             p_item.textContent = `${count} Course in cart`


        })
       
       
         

            

        
       


    }


    function promo(){
        var inp = document.getElementById("inp-coupon").value
        var pri = document.getElementById("total_prie")
        var coupon_para = document.createElement("p")
        var  sucess = document.getElementById("applied")
        var not_sucess = document.getElementById("not_applied")
        if(inp == "SPECIAL26" || inp == "special26"){
            pri.textContent =  "₹"+ total_price  * 0.74
            coupon_para.textContent =   inp + " promo code is applied" 

            sucess.append(coupon_para)
            
        }else {
    coupon_para.textContent = "Invalid promo code";
            not_sucess.append(coupon_para)
        }
    }
    var btnc = document.getElementById("coupon-btn")
    btnc.addEventListener("click", promo)