function insertions() {
    const par1 = document.querySelector("#p1");
    par1.insertAdjacentHTML("afterend", "<p>inséré après le 1er paragraphe</p>");
    const paraC1 = Array.from(document.querySelectorAll(".c1"));
    for (const par of paraC1) {
        let name =  "maryem" ;
        par.insertAdjacentHTML("afterbegin", `hello ${name}`);
        par.insertAdjacentHTML("beforeend", " (inséré à la fin)");
    }
}

const c = document.getElementsByName("body");
const obj = {
    name : "amine" ,
    say_hello : ()=>{
        console.log(`hello my name is ${this.name}`)
    }
}
