export default function WarningBanner(props) {
    if (!props.warn) {
        return null;
    }

    return (
        <div className="warning" style={{color: 'red'}}>
            Предупреждение!
        </div>
    );
}