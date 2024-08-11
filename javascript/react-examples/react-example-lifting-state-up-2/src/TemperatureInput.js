import React from "react";
import {scaleNames} from "./scaleNames";

export default class TemperatureInput extends React.Component {
    constructor(props) {
        super(props);

        this.handleChange = this.handleChange.bind(this);
    }

    handleChange(event) {
        this.props.onTemperatureChange(event.target.value);
    }

    render() {
        const temperature = this.props.temperature;
        const scale = this.props.scale;

        return(
            <fieldset>
                <legend>Введите градусы по шкале {scaleNames[scale]}:</legend>
                <input value={temperature}
                       onChange={this.handleChange} />
            </fieldset>
        );
    }
}