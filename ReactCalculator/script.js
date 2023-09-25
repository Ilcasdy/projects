

class Calculator extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      input: '0',
      total: '',
      previousTotal: '' };

    this.zero = this.zero.bind(this);
    this.one = this.one.bind(this);
    this.two = this.two.bind(this);
    this.three = this.three.bind(this);
    this.four = this.four.bind(this);
    this.five = this.five.bind(this);
    this.six = this.six.bind(this);
    this.seven = this.seven.bind(this);
    this.eight = this.eight.bind(this);
    this.nine = this.nine.bind(this);
    this.plus = this.plus.bind(this);
    this.minus = this.minus.bind(this);
    this.times = this.times.bind(this);
    this.divide = this.divide.bind(this);
    this.decimal = this.decimal.bind(this);
    this.clear = this.clear.bind(this);
    this.equals = this.equals.bind(this);
    this.handleDisplay = this.handleDisplay.bind(this);
    this.handlePlus = this.handlePlus.bind(this);
    this.handleMinus = this.handleMinus.bind(this);
    this.handleTimes = this.handleTimes.bind(this);
    this.handleDivide = this.handleDivide.bind(this);
    this.handleDecimal = this.handleDecimal.bind(this);
    this.handleTotal = this.handleTotal.bind(this);
    this.handleDouble = this.handleDouble.bind(this);
  }
  zero() {
    this.setState({
      input: this.state.input.concat(0),
      total: '' });

  }
  one() {
    this.setState({
      input: this.state.input.concat(1),
      total: '' });

  }
  two() {
    this.setState({
      input: this.state.input.concat(2),
      total: '' });

  }
  three() {
    this.setState({
      input: this.state.input.concat(3),
      total: '' });

  }
  four() {
    this.setState({
      input: this.state.input.concat(4),
      total: '' });

  }
  five() {
    this.setState({
      input: this.state.input.concat(5),
      total: '' });

  }
  six() {
    this.setState({
      input: this.state.input.concat(6),
      total: '' });

  }
  seven() {
    this.setState({
      input: this.state.input.concat(7),
      total: '' });

  }
  eight() {
    this.setState({
      input: this.state.input.concat(8),
      total: '' });

  }
  nine() {
    this.setState({
      input: this.state.input.concat(9),
      total: '' });

  }
  plus() {
    this.setState({
      input: this.state.input.concat('+') });

  }
  minus() {
    this.setState({
      input: this.state.input.concat('-') });

  }
  times() {
    this.setState({
      input: this.state.input.concat('*') });

  }
  divide() {
    this.setState({
      input: this.state.input.concat('/') });

  }
  decimal() {
    this.setState({
      input: this.state.input.concat('.') });

  }
  clear() {

    this.setState({
      input: '0', total: '' });

  }
  equals() {
    let totals = eval(this.state.input);
    this.setState({
      input: '',
      total: totals,
      pastTotal: totals });

  }

  handleDisplay() {
    const expression = /^0\d/;
    const beginningZero = /^0/;
    this.setState(
    { input: this.state.input.replace(expression, this.state.input[1]) });}

  handlePlus() {
    const tooManyPlus = /\+\+/;
    this.setState(state => ({ input: state.input.replace(tooManyPlus, "+") }));
  }
  handleMinus() {
    const tooManyMinus = /\-\-/;
    this.setState(state => ({ input: state.input.replace(tooManyMinus, "-") }));
  }
  handleTimes() {
    const tooManyTimes = /\*\*/;
    this.setState(state => ({ input: state.input.replace(tooManyTimes, "*") }));
  }
  handleDivide() {
    const tooManyDivide = /\/\//;
    this.setState(state => ({ input: state.input.replace(tooManyDivide, "/") }));
  }
  handleDecimal() {
    const tooManyDec = /\d+\.\d*\./;
    this.setState(state => ({ input: state.input.replace(/(?<=\.\d*)\.$/, "") }));}

  handleTotal() {
    const beginningOperator = /^[\+\-\*\/]/;
    let totes = this.state.total;console.log(this.state.total);
    if (this.state.input.match(beginningOperator)) {
      this.setState(state => ({ input: totes + state.input }));
    }
  }
  handleDouble() {
    const doubleOperator = /[\+\-\*\/]+[\+\*\/]/;
    this.setState(state => ({ input: state.input.replace(doubleOperator, state.input[state.input.length - 1]) }));
  }
  render() {
    document.getElementById("root").addEventListener('click', this.handleDisplay);
    document.getElementById("root").addEventListener('click', this.handlePlus);
    document.getElementById("root").addEventListener('click', this.handleMinus);
    document.getElementById("root").addEventListener('click', this.handleTimes);
    document.getElementById("root").addEventListener('click', this.handleDivide);
    document.getElementById("root").addEventListener('click', this.handleDecimal);
    document.getElementById("root").addEventListener('click', this.handleTotal);

    document.getElementById("root").addEventListener('click', this.handleDouble);

    return /*#__PURE__*/(
      React.createElement("div", { class: "col-md-2 container", id: "calculator" }, /*#__PURE__*/
      React.createElement("div", { id: "whole", class: "" }, /*#__PURE__*/
      React.createElement("div", { class: "row" }, /*#__PURE__*/
      React.createElement("button", { class: "col-md-6", id: "clear", onClick: this.clear }, "clear"), /*#__PURE__*/
      React.createElement("span", { class: "col-md-6", id: "display" }, this.state.input, this.state.total)), /*#__PURE__*/




      React.createElement("div", { class: "row" }, /*#__PURE__*/React.createElement("button", { class: "col-md-3", id: "one", onClick: this.one }, "1"), /*#__PURE__*/
      React.createElement("button", { class: "col-md-3", id: "two", onClick: this.two }, "2"), /*#__PURE__*/
      React.createElement("button", { class: "col-md-3", id: "three", onClick: this.three }, "3"), /*#__PURE__*/
      React.createElement("button", { class: "col-md-3", id: "add", onClick: this.plus }, "+")), /*#__PURE__*/

      React.createElement("div", { class: "row" }, /*#__PURE__*/React.createElement("button", { class: "col-md-3", id: "four", onClick: this.four }, "4"), /*#__PURE__*/
      React.createElement("button", { class: "col-md-3", id: "five", onClick: this.five }, "5"), /*#__PURE__*/
      React.createElement("button", { class: "col-md-3", id: "six", onClick: this.six }, "6"), /*#__PURE__*/
      React.createElement("button", { class: "col-md-3", id: "subtract", onClick: this.minus }, "-")), /*#__PURE__*/

      React.createElement("div", { class: "row" }, " ", /*#__PURE__*/React.createElement("button", { class: "col-md-3", id: "seven", onClick: this.seven }, "7"), /*#__PURE__*/
      React.createElement("button", { class: "col-md-3", id: "eight", onClick: this.eight }, "8"), /*#__PURE__*/
      React.createElement("button", { class: "col-md-3", id: "nine", onClick: this.nine }, "9"), /*#__PURE__*/
      React.createElement("button", { class: "col-md-3", id: "multiply", onClick: this.times }, "*")), /*#__PURE__*/

      React.createElement("div", { class: "row" }, /*#__PURE__*/
      React.createElement("button", { class: "col-md-3", id: "decimal", onClick: this.decimal }, "."), /*#__PURE__*/
      React.createElement("button", { class: "col-md-3", id: "zero", onClick: this.zero }, "0"), /*#__PURE__*/
      React.createElement("button", { class: "col-md-3", id: "equals", onClick: this.equals }, "="), /*#__PURE__*/
      React.createElement("button", { class: "col-md-3", id: "divide", onClick: this.divide }, "/")))));










  }}

ReactDOM.render( /*#__PURE__*/React.createElement(Calculator, null), document.getElementById("root"));

