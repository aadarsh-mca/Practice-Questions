import React, { useState } from "react"; 

export default function ToDoItem(props) {
    function delegateToDoItemHandler() {
        props.onClick(props.data);
    }

    return (
        <li onClick={delegateToDoItemHandler}>
            {props.data.inputText}
        </li>
    );
}