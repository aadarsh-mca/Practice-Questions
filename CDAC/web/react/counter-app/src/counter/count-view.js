function showCounterBtn(count) {
    return (
        <div className="counter-div">
            <p>Counter :: {count}</p>

            <button className="btn" id="inc-btn" name="increment">
                Increment Counter
            </button>
            
            <button className="btn" id="dec-btn" name="decrement">
                Decrement Counter
            </button>
            
            <button className="btn" id="reset-btn" name="reset">
                Reset Counter
            </button>
        </div>
    );
}

export default showCounterBtn;