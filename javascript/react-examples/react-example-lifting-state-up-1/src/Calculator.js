import React from "react";
import BoilingVerdict from "./BoilingVerdict";


export default class Calculator extends React.Component {
    constructor(props) {
        super(props);
        this.handleChange = this.handleChange.bind(this);

        this.state = {
            temperature: ''
        }
    }

    handleChange(event) {
        this.setState({temperature: event.target.value})
    }

    render() {
        const temperature = this.state.temperature;

        return (
            <fieldset>
                <legend>Введите температуру в градусах Цельсия:</legend>
                <input
                    value={temperature}
                    onChange={this.handleChange}/>
                        <BoilingVerdict celsius={parseFloat(temperature)}/>
            </fieldset>
        );
    }
}