import React from "react";

class CustomTextInput extends React.Component {
    constructor(props) {
        super(props);

        this.textInput = React.createRef();
        this.focusTextInput = this.focusTextInput.bind(this);
    }

    focusTextInput() {
        this.textInput.current.focus();
    }

    render() {
        return (
            <div>
                <pre>
                    <input ref={this.textInput} type="text"/>
                    <input type="button" value="Focus" onClick={this.focusTextInput} />
                </pre>
            </div>
        );
    }
}

export default CustomTextInput;