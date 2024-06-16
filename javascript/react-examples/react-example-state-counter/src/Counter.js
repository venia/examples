import React from "react";

export class Counter extends React.Component {
    constructor(props) {
        super(props);

        if (!props.increment) {
            this.state = {
                increment: 1,
                workCounter: 0
            }
        } else {
            this.state = {
                increment: parseInt(props.increment),
                workCounter: 0
            }
        }
        console.log("Initialize: increment={" + this.state.increment + "}, workCounter={" + this.state.workCounter + "}");
    }

    componentDidMount() {
        this.timerId = setInterval(
            () => this.updateCounter(),
            2000
        )
    }

    componentWillUnmount() {
        clearTimeout(this.temerId);
    }

    updateCounter() {
        this.setState((state, props) => ({
            workCounter: state.workCounter + state.increment
        }));
        console.log("workCounter: " + this.state.workCounter)
    }

    render() {
        return (
            <div>
                <h3>Counter:</h3> <pre>{this.state.workCounter} !!!</pre>
            </div>
        );
    }
}