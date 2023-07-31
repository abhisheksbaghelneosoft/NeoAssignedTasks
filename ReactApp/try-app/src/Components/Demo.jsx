import React from 'react'

var tryid=1;
const handleClick = () => {
    tryid++;
    document.getElementById("myid").innerHTML +=  `<div id=${tryid}>hiii
    <button onClick='handleRemoveClick'>Click me</button></div>`;
};

function Demo() {
  const handleRemoveClick=()=>{
    console.log("called");
  };
  return (
    <div>
    <div>Demo</div>
    <div id="myid">
    <input type="text" name="name" />
    </div>
    <button onClick={handleClick}>add</button>
    </div>
  )
}

export default Demo