import React,{useState} from "react";
import Item from "./Item.js"

function FrontPage(props){
    const [items, setItems] = useState()
   
    const handleClick = () =>{
        const newItem = {
            title: "New Item",
            count: 0,
            notes: ""
        }
        fetch("http://localhost:4001/items", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(newItem)
        })
        .then(response => response.json())
        .then(data => {
            console.log(data);
        })
        .catch(error => {
            console.error(error);
        });
    }
    return(
        <div>
            <h1>Clicker</h1>
            <button onClick={handleClick}>+</button>
            <Item/>
        </div>
    )
}

export default FrontPage



