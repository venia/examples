import React from "react";

export class Hello extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            message: "my fiend (from state)"
        };
        this.updateMessage = this.updateMessage.bind(this);
    }

    updateMessage() {
        this.setState({
            message: "my friend (from change state)"
        });
    }

    render() {
        return (
            <div>
                <h1>Hello {this.state.message}!</h1>
                <button onClick={this.updateMessage} >Click Me!</button>
            </div>
        );
    }
}