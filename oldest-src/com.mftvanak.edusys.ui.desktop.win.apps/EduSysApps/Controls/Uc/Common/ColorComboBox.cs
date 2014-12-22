using System;
using System.Collections.Generic;
using System.Drawing;
using System.Text;
using System.Windows.Forms;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Common
{
    public class ColorComboBox : ComboBox
    {
        public ColorComboBox()
        {
            this.DrawMode = System.Windows.Forms.DrawMode.OwnerDrawFixed;
            this.DropDownStyle = ComboBoxStyle.DropDownList;
        }

        public Color? SelectedColor
        {
            set
            {
                if (value == null)
                {
                    if (Items.Count > 0)
                    {
                        SelectedIndex = 0;
                        return;
                    }
                }
                foreach (object item in Items)
                {
                    if (item is ColorComboBoxItem)
                    {
                        ColorComboBoxItem colorCombBoxItem = item as ColorComboBoxItem;
                        if (colorCombBoxItem.ForeColor == value.Value)
                        {
                            SelectedItem = item;
                            return;
                        }
                    }
                }
                if (Items.Count > 0)
                {
                    SelectedIndex = 0;
                }
            }
            get
            {
                if (SelectedIndex <= 0)
                {
                    return null;
                }
                return (SelectedItem as ColorComboBoxItem).ForeColor;
            }
        }

        public void AddNullItem()
        {
            this.Items.Add(new NullColorComboBoxItem());
            this.SelectedIndex = 0;
        }

        protected override void OnDrawItem(DrawItemEventArgs e)
        {
            if (e.Index < 0)
            {
                return;
            }
            if (this.Items.Count <= e.Index)
            {
                return;
            }

            base.OnDrawItem(e);
            e.DrawBackground();
            if (this.Items[e.Index] is ColorComboBoxItem)
            {
                ColorComboBoxItem item = (ColorComboBoxItem)this.Items[e.Index];
                Brush brush = new SolidBrush(item.ForeColor);
                e.Graphics.DrawString(item.Text, this.Font, new SolidBrush(Color.Black), e.Bounds.Height + 10, e.Bounds.Y);
                e.Graphics.DrawRectangle(new Pen(new SolidBrush(Color.Black)), 1, e.Bounds.Y + 2, e.Bounds.Height - 4, e.Bounds.Height - 4);
                e.Graphics.FillRectangle(brush, 2, e.Bounds.Y + 3, e.Bounds.Height - 5, e.Bounds.Height - 5);
            }
            else if (this.Items[e.Index] is NullColorComboBoxItem)
            {
                NullColorComboBoxItem item = (NullColorComboBoxItem)this.Items[e.Index];
                e.Graphics.DrawString(item.ToString(), this.Font, new SolidBrush(Color.Black), 10, e.Bounds.Y);
            }
        }
    }

    public class NullColorComboBoxItem
    {
        private string _text = "---------------";

        public override string ToString()
        {
            return _text;
        }
    }

    public class ColorComboBoxItem
    {
        private string text = "";
        public string Text
        {
            get { return text; }
            set { text = value; }
        }

        private object val;
        public object Value
        {
            get { return val; }
            set { val = value; }
        }

        private Color foreColor = Color.Black;
        public Color ForeColor
        {
            get { return foreColor; }
            set { foreColor = value; }
        }

        public override string ToString()
        {
            return text;
        }
    }
}
