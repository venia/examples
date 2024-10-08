import React from "react";
import TemperatureInput from "./TemperatureInput";
import {tryConvert} from "./tryConvert";
import {toCelsius, toFahrenheit} from "./utils";
import {BoilingVerdict} from "./BoilingVerdict";

export default class Calculator extends React.Component {
    constructor(props) {
        super(props);

        this.handleCelsiusChange = this.handleCelsiusChange.bind(this);
        this.handleFahrenheitChange = this.handleFahrenheitChange.bind(this);
        this.state = {temperature: '', scale: 'c'};
    }

    handleCelsiusChange(temperature) {
        this.setState({scale: 'c', temperature});
    }

    handleFahrenheitChange(temperature) {
        this.setState({scale: 'f', temperature});
    }

    render() {
        const scale = this.state.scale;
        const temperature = this.state.temperature;
        const celsius = scale === 'f' ? tryConvert(temperature, toCelsius) : temperature;
        const fahrenheit = scale === 'c' ? tryConvert(temperature, toFahrenheit) : temperature;

        return (
            <>
                <div>
                    <TemperatureInput
                        temperature={celsius}
                        onTemperatureChange={this.handleCelsiusChange}/>
                </div>
                <div>
                    <TemperatureInput
                        scale="f"
                        temperature={fahrenheit}
                        onTemperatureChange={this.handleFahrenheitChange} />
                </div>
                <BoilingVerdict
                    celsius={parseFloat(celsius)} />
            </>
        );

    }
}