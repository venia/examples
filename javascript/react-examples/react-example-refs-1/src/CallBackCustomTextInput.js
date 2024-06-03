import React from "react";

export class CallBackCustomTextInput extends React.Component {
    constructor(props) {
        super(props);

        this.textInput = null;

        this.setCallBackTextinputRef = element => {
            this.textInput = element;
        }

        this.callBackfocustextInput = () => {
            if (this.textInput)
                this.textInput.focus();
        }
    }

    componentDidMount() {
        this.callBackfocustextInput();
    }

    render () {
        return (
            <div>
                <input
                    type="text"
                    ref={this.setCallBackTextinputRef}
                />
                <input
                    type="button"
                    value="Focus the text input"
                    onClick={this.callBackfocustextInput}
                />
            </div>
        );
    }
}