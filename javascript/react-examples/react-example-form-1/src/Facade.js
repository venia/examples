import React from "react";
import NameForm from "./NameForm";
import EssayForm from "./EssayForm";
import FlavorForm from "./FlavorForm";
import Reservation from "./Reservation";

export default class Facade extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <>
                <div>
                    <NameForm></NameForm>
                </div>
                <div>
                    <EssayForm></EssayForm>
                </div>
                <div>
                    <FlavorForm></FlavorForm>
                </div>
                <div><Reservation/></div>
            </>
        );
    }
}