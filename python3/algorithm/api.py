from flask import Flask, request, jsonify
app=Flask(__name__)

#(pytorch) C:\Users\yuhui.liu2>pip install flask
#https://www.codegrepper.com/code-examples/python/%40app.route%28%27%2F%27+methods%3D+%27get%27+%27post%27+%29


@app.route("/predict",methods=['POST'])
def predict():
    # 获取text参数
    text = request.form.get("text") or request.json.get("text") or request.values.get("text")

    # 模型推理得到结果
    pred = [{"label": "订单", "start_offset": 0, "end_offset": 5}]  # or "non-medical"

    # 返回结果
    results = pred
    return jsonify(results)

    return text
if __name__ == '__main__':
    app.run('0.0.0.0',port=5001)