import {useRef} from "react";
import MyInput from "./MyInput";

export default function Form() {
    const ref = useRef(null);

    function handleClick() {
        ref.current.focus();
        ref.current.scrollIntoView();
    }

    return (
        <form>
            <button type="button" onClick={handleClick}>Edit</button>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <MyInput label="Enter your name:" ref={ref}/>
        </form>
    );
}