import React from "react";
import NumberList from "./NumberList";

export default class Container extends React.Component {

    constructor(props, context) {
        super(props, context);
        this.numbers = [1, 2, 3, 4, 5];
    }

    render() {
        return (
            <div>
                <NumberList numbers={this.numbers} />
            </div>
        );

    }
}