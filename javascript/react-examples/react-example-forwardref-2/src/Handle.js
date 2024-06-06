import {useRef} from "react";
import MyVideoPlayer from "./MyVideoPlayer";

export function Handle() {
    const ref = useRef(null);

    return(
        <>
            <button onClick={() => ref.current.play()}>Play</button>
            <button onClick={() => ref.current.pause()}>Pause</button>

            <br/>
            <MyVideoPlayer
                ref={ref}
                type="video/mp4"
                width="250"
                src="https://interactive-examples.mdn.mozilla.net/media/cc0-videos/flower.mp4"
            />
        </>
    );
}