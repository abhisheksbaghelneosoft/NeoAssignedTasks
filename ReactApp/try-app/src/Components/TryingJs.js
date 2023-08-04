import React from 'react'

const handleClick=(event) => {
    event.preventDefault();
    
};

function TryingJs() {
  return (
    <>
    <div>TryingJs</div>
    <button onClick={handleClick(Event)}>Click Here</button>
    </>
  )
}

export default TryingJs