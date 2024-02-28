

//active heder sticky

const header = document.querySelector("header")
window.addEventListener("scroll",()=>{header.classList.toggle("sticky",window.scrollY > 50)})




//active scrolll

const liLink = document.querySelectorAll("header ul li a");
const section = document.querySelectorAll("section");

function activeMenu(){
    let secLength =section.length;
    while(--secLength && window.scrollY + 500 < section[secLength].offsetTop){}
    liLink.forEach(sec => sec.classList.remove("active"));
    liLink[secLength].classList.add("active");
}

activeMenu();
window.addEventListener("scroll",activeMenu);


document.getElementById('contactForm').addEventListener('submit', function(event) {
    event.preventDefault();
    message(); 
  });
  
  function message() {
    var Name = document.getElementById('input-name');
    var email = document.getElementById('input-email');
    var msg = document.getElementById('input-message');
    const success = document.getElementById('success');
    const danger = document.getElementById('danger');
  
    if (Name.value === '' || email.value === '' || msg.value === '') {
      danger.style.display = 'block';
    } else {
      setTimeout(() => {
        Name.value = '';
        email.value = '';
        msg.value = '';
      }, 2000);
  
      success.style.display = 'block';
    }
  
    setTimeout(() => {
      danger.style.display = 'none';
      success.style.display = 'none';
    }, 4000);
  }
  