
export default function NumberList(props) {
    let numbers = props.numbers;
    let listItems = numbers.map((number) =>
        <li>{number}</li>
    );

    return (
        <ul>
            {listItems}
        </ul>
    );
}