import React from "react";
import NameForm from "./NameForm";
import EssayForm from "./EssayForm";

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
            </>
        );
    }
}