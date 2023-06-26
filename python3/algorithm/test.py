from typing import Optional, Any, List

from flask import Flask
app = Flask(__name__)
@app.route('/')
def index():
    return 'Hello World'

def to_list(x: Optional[Any]) -> List[Any]:
    """Convert object to a list if it isn't."""
    if x is None:
        x = []
    elif not isinstance(x, list):
        x = [x]

    return x

if __name__ == '__main__':
    print(to_list(['哈哈','哈市']))
    print("哈哈" in to_list(['哈哈','哈市']))
    # app.debug = True # 设置调试模式，生产模式的时候要关掉debug
    # app.run()