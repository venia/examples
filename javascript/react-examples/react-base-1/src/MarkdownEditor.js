import React from "react";
import {Remarkable} from "remarkable";

class MarkdownEditor extends React.Component {
    constructor(props) {
        super(props);
        this.state = {value: "Hello **World**!"};
        this.handleChange = this.handleChange.bind(this);
    }

    handleChange(e) {
        this.setState(() => {
            return {value: e.target.value};
        })
    }

    getRowMarkup() {
        const md = new Remarkable();
        return {__html: md.render(this.state.value)};
    }

    render () {
        return (
            <div className="MarkdownEditor">
                <h3>Input:</h3>
                <label htmlFor="markdown-content">
                    Enter some markdown
                </label>

                <textarea
                    id="markdown-content"
                    onChange={this.handleChange}
                    defaultValue={this.state.value}
                    />

                <h3>Output:</h3>
                <div className="content"
                     dangerouslySetInnerHTML={this.getRowMarkup()}
                     />
            </div>
        );
    }
}

export default MarkdownEditor;