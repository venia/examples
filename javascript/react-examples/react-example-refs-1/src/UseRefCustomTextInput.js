import React, {useRef} from "react";
export default function UseRefCustomTextInput() {
    const textInput = useRef(null);

    function handleClick() {
        textInput.current.focus();
    }

    return (
        <div style={{borderColor: "red"}} >
            <input type="text" ref={textInput}/>
            <br />
            <input type="button" value="Focus" onClick={handleClick}/>
        </div>
    );
}