import {forwardRef} from "react";

const MyInput = forwardRef(function (props, ref) {
    const {label, ...otherProps} = props;
    return (
        <label>
            {label}
            <input {...otherProps} ref={ref}></input>
        </label>
    )
})

export default MyInput;