import React from "react";

function Dictionary(props) {
    return (
        <div className="term">
            <dt>
                <span className="emoji">{props.value.emoji}</span>
                <span>{props.value.name}</span>
                </dt>
            <dd>{props.value.meaning}</dd>
        </div>
    );
}

export default Dictionary;