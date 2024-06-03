import React from "react";

class RefsComponent extends React.Component {
    constructor(props) {
        super(props);
        this.myRef = React.createRef();
        console.log("Props: ", this.props);
        console.log("MyRefs: ", this.myRef);
    }

    render() {
        return(
            <h2 ref={this.myRef}>RefsComponent</h2>
        );
    }
}

export default RefsComponent;