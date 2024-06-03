import React from "react";

function  CallBackCustomTextInput(props) {
    return (
        <div>
            <input ref={props.inputRef} />
        </div>
    );
}

export default class MyParent extends React.Component {
    render() {
        return (
            <CallBackCustomTextInput
                inputRef={el => {console.log(el); console.log(this.inputElement); this.inputElement = el;}}
            />
        );
    }
}