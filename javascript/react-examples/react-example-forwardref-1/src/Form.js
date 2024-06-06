import {useRef} from "react";
import MyInput from "./MyInput";

export default function Form() {
    const ref = useRef(null);

    function handleClick() {
        ref.current.focus();
    }

    return (
      <form>
          <MyInput label="Enter your name: " ref={ref}></MyInput>
            <button type="button" onClick={handleClick}>
                Edit
            </button>
      </form>
    );
}